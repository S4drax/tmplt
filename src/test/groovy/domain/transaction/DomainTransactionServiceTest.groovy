package domain.transaction


import com.sadrax.tmplt.domain.transaction.DomainTransactionService
import com.sadrax.tmplt.domain.transaction.TransactionRepository
import com.sadrax.tmplt.infrastructure.transaction.kafka.TransactionKafkaPublisher
import spock.lang.Specification

class DomainTransactionServiceTest extends Specification {
    DomainTransactionService service
    TransactionRepository transactionRepository
    TransactionKafkaPublisher transactionKafkaPublisher

    void setup() {
        transactionRepository = Mock(TransactionRepository)
        transactionKafkaPublisher = Mock(TransactionKafkaPublisher)
        service = new DomainTransactionService(transactionRepository, transactionKafkaPublisher)
    }


}
