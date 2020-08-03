package view;

public interface ISO8583TCPDataStringListener 
{
	public void textEmitted(String aTCPData);
	public void resetTextAreas();
	public void deselectFields();
}
