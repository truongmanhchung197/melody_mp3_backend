package com.c0720i2.melody.controller;
import com.c0720i2.melody.model.*;
import com.c0720i2.melody.service.JwtService;
import com.c0720i2.melody.service.userdetail.IUserDetailService;
import com.c0720i2.melody.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;
@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserDetailService guestService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateAccessToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),userDetails.getAuthorities()));
    }
    @GetMapping("/profile")
    public ResponseEntity<String> getProfile(){
        return new ResponseEntity<>("Profile", HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        if (customer != null){
            User user = new User();
            UserDetail userDetails = new UserDetail();
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(1L,"ROLE_USER"));
            user.setRoles(roleSet);
            user.setUsername(customer.getUsername());
            user.setPassword(passwordEncoder.encode(customer.getPassword()));
            userDetails.setAddress(customer.getAddress());
            userDetails.setEmail(customer.getEmail());
            userDetails.setName(customer.getName());
            userDetails.setTel(customer.getTel());
            userDetails.setUser(user);
            user.setUserDetail(userDetails);
            userService.save(user);
            guestService.save(userDetails);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/profile/{username}")
    public ResponseEntity<UserDetail> getProfile(@PathVariable String username){
        User user = userService.findByUsername(username);
        UserDetail userDetail = userService.getUserDetailByUser(user);
        return new ResponseEntity<>(userDetail,HttpStatus.OK);
    }
}