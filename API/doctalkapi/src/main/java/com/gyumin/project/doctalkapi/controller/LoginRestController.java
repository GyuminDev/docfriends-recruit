package com.gyumin.project.doctalkapi.controller;

import com.gyumin.project.doctalkapi.config.security.JwtTokenUtil;
import com.gyumin.project.doctalkapi.dto.LoginRequestDto;
import com.gyumin.project.doctalkapi.dto.LoginResponseDto;
import com.gyumin.project.doctalkapi.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserService jwtUserService;

    @PostMapping(value = "/v1/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            authenticate(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        final UserDetails userDetails = jwtUserService.loadUserByUsername(loginRequestDto.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<LoginResponseDto>(new LoginResponseDto(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
