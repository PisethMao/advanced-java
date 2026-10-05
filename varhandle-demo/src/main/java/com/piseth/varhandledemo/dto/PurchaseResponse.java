package com.piseth.varhandledemo.dto;

public record PurchaseResponse(boolean success, String message, int remainingStock) {
}
