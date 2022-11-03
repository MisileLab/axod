package xyz.misilelaboratory.axod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModLog {

    private static final ModMessageFactory messageFactory = new ModMessageFactory(Axod.MOD_NAME);

    public static Logger getLogger() {
        return LogManager.getLogger(getClassName(), messageFactory);
    }

    private static String getClassName() {
        return new Throwable().getStackTrace()[2].getClassName();
    }

}