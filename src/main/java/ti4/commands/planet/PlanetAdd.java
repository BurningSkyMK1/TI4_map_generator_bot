package ti4.commands.planet;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import ti4.commands.units.AddUnits;
import ti4.generator.Mapper;
import ti4.helpers.AliasHandler;
import ti4.helpers.ButtonHelper;
import ti4.helpers.ButtonHelperFactionSpecific;
import ti4.helpers.Constants;
import ti4.helpers.Helper;
import ti4.map.Map;
import ti4.map.Planet;
import ti4.map.Player;
import ti4.map.UnitHolder;
import ti4.message.MessageHelper;

import java.util.List;

public class PlanetAdd extends PlanetAddRemove {
    public PlanetAdd() {
        super(Constants.PLANET_ADD, "Add Planet");
    }

    @Override
    public void doAction(Player player, String planet, Map activeMap) {
      doAction(player, planet, activeMap, null);
    }

    public void doAction(Player player, String planet, Map activeMap, GenericInteractionCreateEvent event) {
        boolean doubleCheck = Helper.isAllianceModeAndPreviouslyOwnedCheck(activeMap, planet);
        player.addPlanet(planet);
        player.exhaustPlanet(planet);
        if (planet.equals("mirage")){
            activeMap.clearPlanetsCache();
        }
        UnitHolder unitHolder = activeMap.getPlanetsInfo().get(planet);
        String color = player.getColor();
        boolean moveTitanPN = false;
        if (unitHolder != null && color != null && !"null".equals(color)) {
            String ccID = Mapper.getControlID(color);
            String ccPath = Mapper.getCCPath(ccID);
            if (ccPath != null) {
                unitHolder.addControl(ccID);
            }
            if (unitHolder.getTokenList().contains(Constants.ATTACHMENT_TITANSPN_PNG)) {
                moveTitanPN = true;
            } else if (unitHolder.getTokenList().contains(Constants.CUSTODIAN_TOKEN_PNG)) {
                unitHolder.removeToken(Constants.CUSTODIAN_TOKEN_PNG);
                activeMap.scorePublicObjective(player.getUserID(), 0);
                MessageChannel channel = activeMap.getMainGameChannel();
                if(activeMap.isFoWMode()){
                    channel = player.getPrivateChannel();
                }
                MessageHelper.sendMessageToChannel(channel, Helper.getPlayerRepresentation(player, activeMap)+" scored custodians!");
                String message2 = Helper.getPlayerRepresentation(player, activeMap, activeMap.getGuild(), true) + " Click the names of the planets you wish to exhaust to spend 6i.";
                List<Button> buttons = ButtonHelper.getExhaustButtonsWithTG(activeMap, player, event);
                Button DoneExhausting =  Button.danger("deleteButtons", "Done Exhausting Planets");
                buttons.add(DoneExhausting);
                if(!player.hasAbility("reclamation")){
                    MessageHelper.sendMessageToChannelWithButtons(channel, message2, buttons);
                }
            }
        }
        boolean alreadyOwned = false;
        for (Player player_ : activeMap.getPlayers().values()) {
            if (player_ != player) {
                List<String> planets = player_.getPlanets();
                if (planets.contains(planet)) {
                    if (player_.getExhaustedPlanetsAbilities().contains(planet)) {
                        player.exhaustPlanetAbility(planet);
                    }
                    alreadyOwned = true;
                    player_.removePlanet(planet);
                    if (moveTitanPN){
                       if (player_.getPromissoryNotesInPlayArea().contains(Constants.TERRAFORM)){
                           player_.removePromissoryNote(Constants.TERRAFORM);
                           player.setPromissoryNote(Constants.TERRAFORM);
                           player.setPromissoryNotesInPlayArea(Constants.TERRAFORM);
                       }
                    }
                }
            }
        }

        if(activeMap.playerHasLeaderUnlockedOrAlliance(player, "naazcommander"))
        {
            alreadyOwned = false;
        }
        if(activeMap.getActivePlayer() != null && !(activeMap.getActivePlayer().equalsIgnoreCase("")) && player.hasAbility("scavenge") && event != null)
        {
            String fac = Helper.getFactionIconFromDiscord(player.getFaction());
            
            MessageHelper.sendMessageToChannel(event.getMessageChannel(), fac+" gained 1tg from Scavenge ("+player.getTg()+"->"+(player.getTg()+1)+"). Reminder that this is optional, but was done automatically for convenience. You do not legally have this tg prior to exploring." );
            player.setTg(player.getTg()+1);
            ButtonHelperFactionSpecific.pillageCheck(player, activeMap);
        }
        if (!alreadyOwned && !doubleCheck && (!planet.equals("mirage"))&& !activeMap.isBaseGameMode()) {
            Planet planetReal = (Planet) unitHolder;
            List<Button> buttons = ButtonHelper.getPlanetExplorationButtons(activeMap, planetReal);
            if (event != null && buttons != null && !buttons.isEmpty()) {
                String message = "Click button to explore " + Helper.getPlanetRepresentation(planet, activeMap);
                MessageHelper.sendMessageToChannelWithButtons(event.getMessageChannel(), message, buttons);
            }
        }
        if(player.getLeaderIDs().contains("solcommander") && !player.hasLeaderUnlocked("solcommander")){
            ButtonHelper.commanderUnlockCheck(player, activeMap, "sol", event);
        }
        if(player.getLeaderIDs().contains("xxchacommander") && !player.hasLeaderUnlocked("xxchacommander")){
            ButtonHelper.commanderUnlockCheck(player, activeMap, "xxcha", event);
        }
        if(player.getLeaderIDs().contains("sardakkcommander") && !player.hasLeaderUnlocked("sardakkcommander")){
            ButtonHelper.commanderUnlockCheck(player, activeMap, "sardakk", event);
        }
        if(planet.equalsIgnoreCase("mr")&&player.getLeaderIDs().contains("winnucommander") && !player.hasLeaderUnlocked("winnucommander") && player.getPlanets().contains("mr")){
            ButtonHelper.commanderUnlockCheck(player, activeMap, "winnu", event);
        }
        if(planet.equalsIgnoreCase("mr")&& player.hasAbility("reclamation")){
             new AddUnits().unitParsing(event, player.getColor(),
                            activeMap.getTile(AliasHandler.resolveTile(planet)), "sd " + planet + ", pds "+planet, activeMap);
        }
    }
}
