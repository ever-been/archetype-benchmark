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

public class ExampleBenchmark extends Benchmark {

    int runNumber;

    @Override
    public TaskContextDescriptor generateTaskContext() throws BenchmarkException {
        if (runNumber >= 10) {
            return null;
        }

	    runNumber++;

        ContextBuilder contextBuilder = ContextBuilder.createFromResource(this.getClass(), "ContextTemplate.tcd.xml");
        return contextBuilder.build();
    }

    @Override
    public void onResubmit() {

    }

    @Override
    public void onTaskContextFinished(String taskContextId, TaskContextState state) {

    }

}
