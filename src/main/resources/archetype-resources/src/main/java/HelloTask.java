#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.cuni.mff.d3s.been.mq.MessagingException;
import cz.cuni.mff.d3s.been.persistence.DAOException;

import cz.cuni.mff.d3s.been.taskapi.Task;
import cz.cuni.mff.d3s.been.taskapi.TaskException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloTask extends Task {

    private static final Logger log = LoggerFactory.getLogger(HelloTask.class);

    private int pauseBetweenWords;

    @Override
    public void run(String[] strings) throws TaskException, MessagingException, DAOException {
        this.pauseBetweenWords = Integer.parseInt(this.getTaskProperty("pauseBetweenWords", "3"));

        String name = this.getTaskProperty("name");

        System.out.println("Hello " + name);
        pause();
        System.err.println("Aloha " + name);
        pause();
        log.trace("Mae govannen " + name);
        pause();
        log.debug("God dag " + name);
        pause();
        log.info("Salut " + name);
        pause();
        log.warn("你好 " + name);
        pause();
        log.error("שלום " + name);
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(pauseBetweenWords*1000);
        }   catch (Exception e) {
            // ignore
        }
    }

}
