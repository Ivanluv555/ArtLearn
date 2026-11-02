package org.hyjava.hyall.module.address.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hyjava.hyall.common.core.result.Result;

import org.hyjava.hyall.module.address.pojo.Address;
import org.hyjava.hyall.module.address.pojo.dto.AddressDTO;
import org.hyjava.hyall.module.address.service.IAddrService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "地址管理", description = "用户收货地址的增删改查接口")
@RestController
@RequestMapping("/address")
public class AddrController {
    private final IAddrService addrservice;

    public AddrController(IAddrService addrservice) {
        this.addrservice = addrservice;
    }

    @Operation(summary = "添加地址", description = "添加用户收货地址")
    @PostMapping
    public Result<Address> addUserAddress(
            @Parameter(description = "地址信息", required = true) @RequestBody @Validated AddressDTO address) {
        Address naddress = addrservice.addUserAddress(address);
        return Result.success(naddress);
    }

    @Operation(summary = "删除地址", description = "根据地址ID删除用户地址")
    @DeleteMapping
    public void deleteUserAddress(
            @Parameter(description = "地址ID", required = true) @RequestBody Integer addressId) {
        addrservice.deleteUserAddress(addressId);
    }

    @Operation(summary = "更新地址", description = "修改用户收货地址信息")
    @PutMapping
    public Result<Address> updateUserAddress(
            @Parameter(description = "地址信息", required = true) @RequestBody @Validated AddressDTO address) {
        Address naddress = addrservice.updateUserAddress(address);
        return Result.success(naddress);
    }

    @Operation(summary = "查询地址", description = "根据地址ID查询地址详情")
    @GetMapping
    public Result<Address> queryUserAddress(
            @Parameter(description = "地址ID", required = true) @RequestBody Integer addressId) {
        Address naddress = addrservice.queryUserAddress(addressId);
        return Result.success(naddress);
    }
}
