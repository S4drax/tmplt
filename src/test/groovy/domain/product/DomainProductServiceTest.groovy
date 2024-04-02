package domain.product

import com.sadrax.tmplt.domain.product.DomainProductService
import com.sadrax.tmplt.domain.product.ProductRepository
import com.sadrax.tmplt.domain.product.model.ProductPartial
import spock.lang.Specification

class DomainProductServiceTest extends Specification {
    DomainProductService service;
    ProductRepository productRepository;

    void setup() {
        productRepository = Mock(ProductRepository)
        service = new DomainProductService(productRepository)
    }

    def 'should get product list without parameters'() {
        given:
        def partial1 = ProductPartial.builder()
                .name("Test Product 1")
                .price(BigDecimal.valueOf(10))
                .stock(4)
                .build()
        def partial2 = ProductPartial.builder()
                .name("Test Product 2")
                .price(BigDecimal.valueOf(9.91))
                .stock(1)
                .build()
        when:
        service.getProductList(null, null)
        then:
        1 * productRepository.getProductList(_, _) >> List.of(partial1, partial2)
    }
}
