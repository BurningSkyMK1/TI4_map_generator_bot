
package ti4.map_ttpg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "laws",
    "objectives",
    "active",
    "alliances",
    "color",
    "colorActual",
    "commandTokens",
    "custodiansPoints",
    "handCards",
    "factionName",
    "factionShort",
    "leaders",
    "steamName",
    "planetCards",
    "relicCards",
    "score",
    "strategyCards",
    "strategyCardsFaceDown",
    "technologies",
    "commodities",
    "tradeGoods",
    "maxCommodities"
})
public class TTPGPlayer {

    @JsonProperty("laws")
    private List<Object> laws = null;
    @JsonProperty("objectives")
    private List<String> objectives = null;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("alliances")
    private List<Object> alliances = null;
    @JsonProperty("color")
    private String color;
    @JsonProperty("colorActual")
    private String colorActual;
    @JsonProperty("commandTokens")
    private TTPGCommandTokens commandTokens;
    @JsonProperty("custodiansPoints")
    private Integer custodiansPoints;
    @JsonProperty("handCards")
    private List<String> handCards = null;
    @JsonProperty("factionName")
    private String factionName;
    @JsonProperty("factionShort")
    private String factionShort;
    @JsonProperty("leaders")
    private TTPGLeaders leaders;
    @JsonProperty("steamName")
    private String steamName;
    @JsonProperty("planetCards")
    private List<String> planetCards = null;
    @JsonProperty("relicCards")
    private List<String> relicCards = null;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("strategyCards")
    private List<Object> strategyCards = null;
    @JsonProperty("strategyCardsFaceDown")
    private List<Object> strategyCardsFaceDown = null;
    @JsonProperty("technologies")
    private List<String> technologies = null;
    @JsonProperty("commodities")
    private Integer commodities;
    @JsonProperty("tradeGoods")
    private Integer tradeGoods;
    @JsonProperty("maxCommodities")
    private Integer maxCommodities;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("laws")
    public List<Object> getLaws() {
        return laws;
    }

    @JsonProperty("laws")
    public void setLaws(List<Object> laws) {
        this.laws = laws;
    }

    @JsonProperty("objectives")
    public List<String> getObjectives() {
        return objectives;
    }

    @JsonProperty("objectives")
    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("alliances")
    public List<Object> getAlliances() {
        return alliances;
    }

    @JsonProperty("alliances")
    public void setAlliances(List<Object> alliances) {
        this.alliances = alliances;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("colorActual")
    public String getColorActual() {
        return colorActual;
    }

    @JsonProperty("colorActual")
    public void setColorActual(String colorActual) {
        this.colorActual = colorActual;
    }

    @JsonProperty("commandTokens")
    public TTPGCommandTokens getCommandTokens() {
        return commandTokens;
    }

    @JsonProperty("commandTokens")
    public void setCommandTokens(TTPGCommandTokens commandTokens) {
        this.commandTokens = commandTokens;
    }

    @JsonProperty("custodiansPoints")
    public Integer getCustodiansPoints() {
        return custodiansPoints;
    }

    @JsonProperty("custodiansPoints")
    public void setCustodiansPoints(Integer custodiansPoints) {
        this.custodiansPoints = custodiansPoints;
    }

    @JsonProperty("handCards")
    public List<String> getHandCards() {
        return handCards;
    }

    @JsonProperty("handCards")
    public void setHandCards(List<String> handCards) {
        this.handCards = handCards;
    }

    @JsonProperty("factionName")
    public String getFactionName() {
        return factionName;
    }

    @JsonProperty("factionName")
    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    @JsonProperty("factionShort")
    public String getFactionShort() {
        return factionShort;
    }

    @JsonProperty("factionShort")
    public void setFactionShort(String factionShort) {
        this.factionShort = factionShort;
    }

    @JsonProperty("leaders")
    public TTPGLeaders getLeaders() {
        return leaders;
    }

    @JsonProperty("leaders")
    public void setLeaders(TTPGLeaders leaders) {
        this.leaders = leaders;
    }

    @JsonProperty("steamName")
    public String getSteamName() {
        return steamName;
    }

    @JsonProperty("steamName")
    public void setSteamName(String steamName) {
        this.steamName = steamName;
    }

    @JsonProperty("planetCards")
    public List<String> getPlanetCards() {
        return planetCards;
    }

    @JsonProperty("planetCards")
    public void setPlanetCards(List<String> planetCards) {
        this.planetCards = planetCards;
    }

    @JsonProperty("relicCards")
    public List<String> getRelicCards() {
        return relicCards;
    }

    @JsonProperty("relicCards")
    public void setRelicCards(List<String> relicCards) {
        this.relicCards = relicCards;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("strategyCards")
    public List<Object> getStrategyCards() {
        return strategyCards;
    }

    @JsonProperty("strategyCards")
    public void setStrategyCards(List<Object> strategyCards) {
        this.strategyCards = strategyCards;
    }

    @JsonProperty("strategyCardsFaceDown")
    public List<Object> getStrategyCardsFaceDown() {
        return strategyCardsFaceDown;
    }

    @JsonProperty("strategyCardsFaceDown")
    public void setStrategyCardsFaceDown(List<Object> strategyCardsFaceDown) {
        this.strategyCardsFaceDown = strategyCardsFaceDown;
    }

    @JsonProperty("technologies")
    public List<String> getTechnologies() {
        return technologies;
    }

    @JsonProperty("technologies")
    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    @JsonProperty("commodities")
    public Integer getCommodities() {
        return commodities;
    }

    @JsonProperty("commodities")
    public void setCommodities(Integer commodities) {
        this.commodities = commodities;
    }

    @JsonProperty("tradeGoods")
    public Integer getTradeGoods() {
        return tradeGoods;
    }

    @JsonProperty("tradeGoods")
    public void setTradeGoods(Integer tradeGoods) {
        this.tradeGoods = tradeGoods;
    }

    @JsonProperty("maxCommodities")
    public Integer getMaxCommodities() {
        return maxCommodities;
    }

    @JsonProperty("maxCommodities")
    public void setMaxCommodities(Integer maxCommodities) {
        this.maxCommodities = maxCommodities;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
