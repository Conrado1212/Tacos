package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Order;
import tacos.data.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/orders/finish")
@SessionAttributes("order")
public class FinishOrderController {

    private IngredientRepository ingredientRepo;

    @Autowired
    public FinishOrderController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping
    public String showOrder(Model model, Order order, SessionStatus sessionStatus) {
        model.addAttribute("myTacos", order.getTacos());

        model.addAttribute("name", order.getDName());
        model.addAttribute("street", order.getDStreet());
        model.addAttribute("city", order.getDCity());
        model.addAttribute("state", order.getDState());
        model.addAttribute("zip", order.getDZip());
        sessionStatus.setComplete();
        return "finish";
    }

}
