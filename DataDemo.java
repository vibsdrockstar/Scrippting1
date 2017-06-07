package JXLSProj;

public class MyData
{
  private String scenType = "";
  private String avgRespTime = "";
  private String avgPageThinkTime = "";
  private String pageFailureRate = "";
  private String  vusers = "";
  private String  sessionRate = "";


  MyData(String scenType, String avgRespTime, String avgPageThinkTime, String pageFailureRate, String vusers, String sessionRate)
  {
    this.scenType = scenType;
    this.avgRespTime = avgRespTime;
    this.avgPageThinkTime = avgPageThinkTime;
    this.pageFailureRate = pageFailureRate;
    this.vusers = vusers;
    this.sessionRate = sessionRate;
  }
}
