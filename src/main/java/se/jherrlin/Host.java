package se.jherrlin;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.log4j.Logger;

public abstract class Host{

    String mode;
    int port;
    int bufsize;
    int mtr;
    int seconds;
    String ip;

    final Logger LOG = Logger.getLogger(this.getClass().getSimpleName());

    public Host(CommandLine cmd) {
        this.mode = cmd.getOptionValue("m");
        try{
            this.port = cmd.getOptionValue("p") == null ? 4950 : Integer.parseInt(cmd.getOptionValue("p"));
        }
        catch(NumberFormatException as e){
            LOG.debug(e)
        }
        
        this.bufsize = cmd.getOptionValue("b") == null ? 1024 : Integer.parseInt(cmd.getOptionValue("b"));
        this.ip = cmd.getOptionValue("i") == null ? "0.0.0.0" : cmd.getOptionValue("i");
        this.mtr = cmd.getOptionValue("t") == null ? 1 : Integer.parseInt(cmd.getOptionValue("t"));
        this.seconds = cmd.getOptionValue("s") == null ? 1 : Integer.parseInt(cmd.getOptionValue("s"));  // Elvis has just left the building

        LOG.debug("initialized: " + this);
    }

    public void run() throws UnsupportedOperationException {
        // Override this method
        throw new UnsupportedOperationException();
    }

    public boolean valid(){
        // IP address
        InetAddressValidator inetAddressValidator = new InetAddressValidator();
        if (!inetAddressValidator.isValid(this.ip)){
            LOG.debug("%s is not a valid IPv4 address", this.ip);
            return false;
        }
        // Port
        if (this.port > 65535 || this.port < 1 ){
            LOG.debug("%s is not in the valid port range(1-65535)", this.port);           
            return false;
        }
        return true;
    }

    public void sleep(){
        try{
            Thread.sleep(1000/this.mtr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName()+": { " +
                "mode: " + mode + ", " +
                "port: " + port + ", " +
                "bufsize: " + bufsize + ", " +
                "mtr: " + mtr + ", " +
                "seconds: " + seconds + ", " +
                "ip: " + ip +
                " }";
    }
}
