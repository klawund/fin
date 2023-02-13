package com.klawund.fin.client.entry.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "entry", path = "entries")
@Component
public interface EntryFeignClient
{
}
