/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.users.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author hirofumi_tsutsui
 *
 */
@Data
public class UsersForm {
    
    private Integer id;
    
    @NotEmpty
    private String loginName;
    
    @NotEmpty
    private String passwd;
}
