package io.jpabuddy;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class UuidGenPerformance {

    @Benchmark
    public UUID measureSingle() {
        return UUID.randomUUID();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(UuidGenPerformance.class.getSimpleName())
                .forks(100)
                .warmupIterations(1000)
                .warmupTime(TimeValue.NONE)
                .measurementIterations(10_000)
                .measurementTime(TimeValue.NONE)
                .build();
        new Runner(opt).run();
    }


}