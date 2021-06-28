public class App {
    public static void main(String[] args) throws Exception {
        PSExecute pse = new PSExecute("C:\\Users\\USER\\Dev\\Sql.ps1");
        String res = pse.execute("-query 'select * from Datastore.dbo.Data where id=17313' ");
        System.out.println(res);
    }
}
