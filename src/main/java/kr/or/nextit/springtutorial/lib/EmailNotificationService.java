package kr.or.nextit.springtutorial.lib;

public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("[이메일 알림]" + message);
    }
}
