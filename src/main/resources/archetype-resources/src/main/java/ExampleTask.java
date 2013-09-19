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


public class ExampleTask extends Task {

    private static final Logger log = LoggerFactory.getLogger(ExampleTask.class);

    @Override
    public void run(String[] strings) throws TaskException, MessagingException, DAOException {
        log.info("Hello World!");
    }

}
