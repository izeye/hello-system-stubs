package uk.org.webcompere.systemstubs.environment;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link EnvironmentVariables}.
 *
 * @author Johnny Lim
 */
class EnvironmentVariablesTests {

    @Test
    void execute() throws Exception {
        AtomicBoolean executed = new AtomicBoolean();
        new EnvironmentVariables("a", "b").execute(() -> {
            executed.set(true);
            assertThat(System.getenv("a")).isEqualTo("b");
        });
        assertThat(executed).isTrue();
    }

}
