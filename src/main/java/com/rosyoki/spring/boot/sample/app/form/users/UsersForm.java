/**
 * 
 */
package com.rosyoki.spring.boot.sample.app.form.users;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

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
