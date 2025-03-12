package ru.flowstory.store.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flowstory.store.dto.CartItemDTO;
import ru.flowstory.store.dto.OrderDTO;
import ru.flowstory.store.dto.ProductDTO;
import ru.flowstory.store.models.CartItem;
import ru.flowstory.store.models.CartItemId;
import ru.flowstory.store.models.Order;
import ru.flowstory.store.models.Product;
import ru.flowstory.store.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public OrderService(OrderRepository orderRepository, ProductService productService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }


    public Optional<Order> findByCustomerMobile(String mobile) {
        return orderRepository.findByCustomerMobile(mobile);
    }
//    public void updateStatus(int orderId, boolean executed) {
//        Order order = orderRepository.findById(orderId).orElse(null);
//        if (order != null) {
//            orderRepository.save(order);
//        }
//    }

    @Transactional
    public void createOrder(OrderDTO orderDTO) {
        List<CartItemDTO> cartItemDTOItems = orderDTO.getCartItems();
        List<CartItem> cartItems = new ArrayList<>();
        Order orderToAdd = convertToOrder(orderDTO);
        for (CartItemDTO itemDTO : cartItemDTOItems) {
            CartItem item = new CartItem(orderToAdd, productService.getProduct(itemDTO.getProductId()), itemDTO.getQuantity());
            cartItems.add(item);
        }
        orderToAdd.setCartItems(cartItems);
        orderToAdd.setOrderDate(LocalDateTime.now());
        orderRepository.save(orderToAdd);
    }

//
//    @Transactional
//    public void addAllToCart(List<CartItem> itemsToAdd) {
//        for (CartItem item : itemsToAdd) {
//            Optional<Product> product = productService.findById(item.getProduct().getId());
//            if (product.isPresent() && product.get().isInStock()) {
//                order.update(product.get(), item.getQuantity());
//                updated = true;
//            }
//        }
//        orderRepository.save(cart);
//    }
//
//    @Transactional
//    public void save(Order order) {
//        enrichOrder(order);
//        orderRepository.save(order);
//    }
//
//    private void enrichOrder(Order order) {
//        int productsCost = cartService.getCartOrCreate(order.getCustomerMobile()).getProductsCost();
//        order.setTotalPrice(order.isDeliveryIncluded() ? (productsCost + MarketProperties.getDeliveryCost()) : productsCost);
//        order.setOrderDate(LocalDateTime.now());
//    }

    private Order convertToOrder(OrderDTO orderDTO) {        return modelMapper.map(orderDTO, Order.class);    }

    private OrderDTO convertToOrderDTO(Order order) {        return modelMapper.map(order, OrderDTO.class);    }

    private CartItem convertToCartItem(CartItemDTO cartItemDTO) { return modelMapper.map(cartItemDTO, CartItem.class); }

    private Product convertToProduct(ProductDTO productDTO) { return modelMapper.map(productDTO, Product.class);    }
}
