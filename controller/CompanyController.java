package com.company.booking.controller;

import com.company.booking.dto.request.CreateCompanyRequest;
import com.company.booking.dto.response.CompanyResponse;
import com.company.booking.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse create(@Valid @RequestBody CreateCompanyRequest request) {
        return companyService.create(request);
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyService.getAll();
    }
}