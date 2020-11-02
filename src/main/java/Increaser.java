public class Increaser implements Runnable {
    private MailSender mailSender;
    public Increaser(MailSender mailSender){
        this.mailSender=mailSender;
    }

    @Override
    public void run() {

        for (int i = 0; i <mailSender.getLongitud() ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mailSender.Sender(i);
        }

    }
}
