package com.hernanurban.user.dto;

import java.time.LocalDate;

public record UserRequest(String email, String name, LocalDate dateOfBirth) {}
