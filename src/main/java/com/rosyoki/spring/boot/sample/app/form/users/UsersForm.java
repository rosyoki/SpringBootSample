/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.form.users;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author hirofumi_tsutsui
 *
 */
@Data
public class UsersForm {
    
    private Long id;
    
    @NotEmpty
    private String loginName;
    
    @NotEmpty
    private String passwd;
    
}
