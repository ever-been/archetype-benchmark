#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.cuni.mff.d3s.been.benchmarkapi.Benchmark;
import cz.cuni.mff.d3s.been.benchmarkapi.BenchmarkException;
import cz.cuni.mff.d3s.been.benchmarkapi.ContextBuilder;
import cz.cuni.mff.d3s.been.core.task.TaskContextDescriptor;
import cz.cuni.mff.d3s.been.core.task.TaskContextState;

public class HelloBenchmark extends Benchmark
{

    private static final Logger log = LoggerFactory.getLogger(HelloBenchmark.class);

    int runNumber;

    @Override
    public TaskContextDescriptor generateTaskContext() throws BenchmarkException {
        String[] names = this.getTaskProperty("names", "EverBEEN").split(",");
        if (runNumber >= names.length) {
            return null;
        }

        ContextBuilder contextBuilder = ContextBuilder.createFromResource(this.getClass(), "HelloContext.tcd.xml");
        contextBuilder.setProperty("name", names[runNumber]);
        runNumber++;

        return contextBuilder.build();
    }

    @Override
    public void onResubmit() {
        log.info("Task resubmitted");
    }

    @Override
    public void onTaskContextFinished(String taskContextId, TaskContextState state) {
        log.info("Task context finished");
    }

}
