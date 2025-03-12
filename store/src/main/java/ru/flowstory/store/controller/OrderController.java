package ru.flowstory.store.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.flowstory.store.dto.OrderDTO;
import ru.flowstory.store.models.Order;
import ru.flowstory.store.models.Product;
import ru.flowstory.store.dto.ProductDTO;
import ru.flowstory.store.services.OrderService;
import ru.flowstory.store.services.ProductService;
import ru.flowstory.store.util.OrderErrorResponse;
import ru.flowstory.store.util.OrderNotCreatedException;
import ru.flowstory.store.util.OrderNotFoundException;


import javax.validation.Valid;

import static ru.flowstory.store.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid OrderDTO orderDTO,
                                             BindingResult bindingResult)  {
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        orderService.createOrder(orderDTO);

        // HTTP-ответ с пустым телом и статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException e) {
        OrderErrorResponse response = new OrderErrorResponse(
                "Order with this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }

    @ExceptionHandler
    private ResponseEntity<OrderErrorResponse> handleException(OrderNotCreatedException e) {
        OrderErrorResponse response = new OrderErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 403
    }

}
