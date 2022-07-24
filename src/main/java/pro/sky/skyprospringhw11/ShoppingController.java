package pro.sky.skyprospringhw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/order")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/add")

    public ShoppingBasket addShoppingBasket(@RequestParam("id") List id) {
        return shoppingService.addShoppingBasket(id);
    }

    @GetMapping("/get")

    public String getShoppingBasketAsJSON() throws JsonProcessingException {
        return shoppingService.getShoppingBasketAsJSON();
    }
}
