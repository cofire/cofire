package com.cofire.console.service.sytem;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String, String>> getUserResource(String userId);
}
