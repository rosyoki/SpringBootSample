/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.postal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosyoki.spring.boot.sample.app.users.entity.PostZipData;
import com.rosyoki.spring.boot.sample.app.users.repository.PostAlRepository;

/**
 * @author hirofumi_tsutsui
 *
 */
@Service
@Transactional
public class PostAlService {
    @Autowired
    PostAlRepository postAlRepository;
    
    public List<PostZipData> getPostAlAllData() {
        return postAlRepository.findAll();
    }
}
