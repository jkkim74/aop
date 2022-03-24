package com.example.aop2.exam;

import com.example.aop2.exam.annotation.Retry;
import com.example.aop2.exam.annotation.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 1번 실패하는 요청
     */
    @Trace
    @Retry(4)
    public String save(String itemId){
        seq++;
        log.info("request={}",itemId);
        if(seq % 5 == 0){
            throw new IllegalStateException("예외발생");
        }

        return "ok";
    }
}
