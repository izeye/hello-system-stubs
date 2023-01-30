package uk.org.webcompere.systemstubs;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.org.webcompere.systemstubs.SystemStubs.withEnvironmentVariable;

/**
 * Tests for {@link SystemStubs}.
 *
 * @author Johnny Lim
 */
class SystemStubsTests {

    @Test
    void withEnvironmentVariableExecute() throws Exception {
        AtomicBoolean executed = new AtomicBoolean();
        withEnvironmentVariable("a", "b").execute(() -> {
            executed.set(true);
            assertThat(System.getenv("a")).isEqualTo("b");
        });
        assertThat(executed).isTrue();
    }

}
