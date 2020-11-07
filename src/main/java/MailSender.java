public class MailSender implements Runnable {
    private String lastUser;
    private String user;

    public MailSender(String lastUser, String user)
    {
        this.lastUser = lastUser;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Estimado "+user+", usuario "+lastUser+" ha unido a nuestro grupo.");
    }
/*
    private final MemberCreator member;
    private int longitud;
    public MailSender(MemberCreator member){
        this.member=member;
    }
    @Override
    public  void run() {
        System.out.println("MailSender Started");
        while (true){
             longitud= this.member.Correo().size();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.member.Correo().size() ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(longitud!=this.member.Correo().size()){
                    this.member.Informar(i);
                }
            }
        }
    }
*/
}
