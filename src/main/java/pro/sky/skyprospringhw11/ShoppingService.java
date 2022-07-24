package pro.sky.skyprospringhw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class ShoppingService {
    private final List<ShoppingBasket> shopping = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public ShoppingService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ShoppingBasket addShoppingBasket(List id) {
        ShoppingBasket shoppingBasket = new ShoppingBasket(id);
        shopping.add(shoppingBasket);
        return shoppingBasket;
    }

    public String getShoppingBasketAsJSON() throws JsonProcessingException {
        return objectMapper.writeValueAsString(shopping);
    }
}
