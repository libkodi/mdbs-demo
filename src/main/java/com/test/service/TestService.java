package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.TestMapper;

import io.github.libkodi.mdbs.MultiDataSource;
import io.github.libkodi.mdbs.interfaces.Callback;

@Service
public class TestService {
	@Autowired
	private MultiDataSource mdbs;
	
	public String name(String databaseId) throws Exception {
		return mdbs.openSession(databaseId, (Callback<String>) session -> {
			TestMapper mapper = session.getMapper(TestMapper.class);
			return mapper.name();
		});
	}
}
