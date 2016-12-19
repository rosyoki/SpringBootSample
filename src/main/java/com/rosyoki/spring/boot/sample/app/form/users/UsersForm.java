/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.form.users;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * @author hirofumi_tsutsui
 *
 */
@Data
public class UsersForm {
    
    private Long id;
    
    @NotEmpty
    @Range(min=6, max=99)
    private String loginName;
    
    @NotEmpty
    private String passwd;
    
}
