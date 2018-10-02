import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeTableRow {
    private String stationShortCode;
    private Integer stationUICCode;
    private String countryCode;
    private String type;
    private boolean trainStopping;
    private Date scheduledTime;
    private Date actualTime;

    @Override
    public String toString() {
        return "TimeTableRow{" +
                "stationShortCode='" + stationShortCode + '\'' +
                ", stationUICCode=" + stationUICCode +
                ", countryCode='" + countryCode + '\'' +
                ", type='" + type + '\'' +
                ", trainStopping=" + trainStopping +
                ", scheduledTime=" + scheduledTime +
                ", actualTime=" + actualTime +
                '}';
    }

    public String getStationShortCode() {
        return stationShortCode;
    }

    public void setStationShortCode(String stationShortCode) {
        this.stationShortCode = stationShortCode;
    }

    public Integer getStationUICCode() {
        return stationUICCode;
    }

    public void setStationUICCode(Integer stationUICCode) {
        this.stationUICCode = stationUICCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTrainStopping() {
        return trainStopping;
    }

    public void setTrainStopping(boolean trainStopping) {
        this.trainStopping = trainStopping;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }
}
