import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Powershell Executer class
 */
class PSExecute {
    private String path;


    /**
     * Constructor for the powershell executer class
     * @param path
     */
    PSExecute(String path) {
        this.path = path;
    }

    /**
     * Set the path of the object to run
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Executes the Powershell object
     * @param args arguments - if any. If there are no arguments leave blank quotes
     * @return The result after running the object
     * @throws IOException
     */
    public String execute(String args) throws IOException {
        String cmd = "powershell.exe -command \"" + this.path + "\" " + args + "";
        System.out.println("Command running: " + cmd);
        Process powershellProcess = Runtime.getRuntime().exec(cmd);
        powershellProcess.getOutputStream().close();
        String res = "", temp;
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
            powershellProcess.getInputStream()));
            while ((temp = stdout.readLine()) != null) {
               res += temp;
            }
            stdout.close();
        return res;
    }

}
