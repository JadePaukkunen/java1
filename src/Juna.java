import java.util.Date;
import java.util.List;

class Juna extends hakuToiminnot {
    boolean cancelled;
    String commuterLineID;
    Date departureDate;
    String operatorShortCode;
    int operatorUICCode;
    boolean runningCurrently;
    List<TimeTableRow> timeTableRows;
    Date timetableAcceptanceDate;
    String timetableType;
    String trainCategory;
    int trainNumber;
    String trainType;
    long version;


    @Override
    public String toString() {

        return "" + junanAsemaTiedot();
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getCommuterLineID() {
        return commuterLineID;
    }

    public void setCommuterLineID(String commuterLineID) {
        this.commuterLineID = commuterLineID;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getOperatorShortCode() {
        return operatorShortCode;
    }

    public void setOperatorShortCode(String operatorShortCode) {
        this.operatorShortCode = operatorShortCode;
    }

    public int getOperatorUICCode() {
        return operatorUICCode;
    }

    public void setOperatorUICCode(int operatorUICCode) {
        this.operatorUICCode = operatorUICCode;
    }

    public boolean isRunningCurrently() {
        return runningCurrently;
    }

    public void setRunningCurrently(boolean runningCurrently) {
        this.runningCurrently = runningCurrently;
    }

    public List<TimeTableRow> getTimeTableRows() {
        return timeTableRows;
    }

    public void setTimeTableRows(List<TimeTableRow> timeTableRows) {
        this.timeTableRows = timeTableRows;
    }

    public Date getTimetableAcceptanceDate() {
        return timetableAcceptanceDate;
    }

    public void setTimetableAcceptanceDate(Date timetableAcceptanceDate) {
        this.timetableAcceptanceDate = timetableAcceptanceDate;
    }

    public String getTimetableType() {
        return timetableType;
    }

    public void setTimetableType(String timetableType) {
        this.timetableType = timetableType;
    }

    public String getTrainCategory() {
        return trainCategory;
    }

    public void setTrainCategory(String trainCategory) {
        this.trainCategory = trainCategory;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String vainJunanTiedot() { // yhdistetään junan tyyppi ja numero
        return "Juna: " + trainType + trainNumber + " Lähtee: " + timeTableRows.get(0).getFormatoituScheduledTime();
    }

    public String junanAsemaTiedot() { // tulostaa aseman tiedot ja saapumis- sekä lähtöajan
        System.out.println("Asema: " + asemienYhdistäminen(timeTableRows.get(0).getStationShortCode())
                + " Lähtöaika: "+timeTableRows.get(0).getFormatoituScheduledTime());
        for (int i = 2; i < timeTableRows.size(); i += 2) {

            System.out.println("Asema: " + asemienYhdistäminen(timeTableRows.get(i).getStationShortCode())
                    + " Saapumisaika: " + timeTableRows.get(i-1).getFormatoituScheduledTime()
                    + " Lähtöaika: " + timeTableRows.get(i).getFormatoituScheduledTime());

        }
        int viimeinen = timeTableRows.size() - 1;
        return "Asema: " + asemienYhdistäminen(timeTableRows.get(viimeinen).getStationShortCode())
                + " Saapumisaika: " + timeTableRows.get(viimeinen).getFormatoituScheduledTime();


        }


}






