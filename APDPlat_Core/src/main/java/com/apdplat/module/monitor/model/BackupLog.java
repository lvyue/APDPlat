/**
 * 
 * APDPlat - Application Product Development Platform
 * Copyright (c) 2013, 杨尚川, yang-shangchuan@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.apdplat.module.monitor.model;

import com.apdplat.platform.annotation.IgnoreBusinessLog;
import com.apdplat.platform.annotation.IgnoreUser;
import com.apdplat.platform.annotation.ModelAttr;
import com.apdplat.platform.generator.ActionGenerator;
import com.apdplat.platform.model.Model;
import com.apdplat.platform.util.ConvertUtils;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *不需要保存该模型的增删改日志
 * 不需要自动设置模型的添加用户
 * @author 杨尚川
 */
@Entity
@Scope("prototype")
@Component
@Searchable
@IgnoreBusinessLog
@IgnoreUser
public class BackupLog extends Model {
    public String getProcessTimeStr(){
        return ConvertUtils.getTimeDes(processTime);
    }
    @ModelAttr("登录IP地址")
    protected String loginIP;
    @ModelAttr("服务器IP地址")
    protected String serverIP;
    @ModelAttr("应用系统名称")
    protected String appName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @SearchableProperty(format="yyyy-MM-dd")
    @ModelAttr("开始备份时间")
    protected Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @SearchableProperty(format="yyyy-MM-dd")
    @ModelAttr("备份完成时间")
    protected Date endTime;

    //单位为毫秒
    @ModelAttr("操作耗时")
    protected Long processTime;

    @SearchableProperty
    @ModelAttr("操作类型")
    protected String operatingType;
    @SearchableProperty
    @ModelAttr("操作结果")
    protected String operatingResult;

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOperatingResult() {
        return operatingResult;
    }

    public void setOperatingResult(String operatingResult) {
        this.operatingResult = operatingResult;
    }

    public Long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Long processTime) {
        this.processTime = processTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public String getOperatingType() {
        return operatingType;
    }

    public void setOperatingType(String operatingType) {
        this.operatingType = operatingType;
    }

    @Override
    public String getMetaData() {
        return "备份恢复日志";
    }
    public static void main(String[] args){
        BackupLog obj=new BackupLog();
        //生成Action
        ActionGenerator.generate(obj.getClass());
    }
}