package shared;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import java.time.Instant;
import java.util.List;

public interface UrlRepository extends CassandraRepository<UrlEntry, String> {
    @Query("SELECT * FROM urls WHERE created_at < ?0 ALLOW FILTERING")
    List<UrlEntry> findAllOlderThan(Instant threshold);
}
