package com.cdy.ecommerce.member;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private MemberService sut;

    @Test
    @DisplayName("회원생성성공")
    void createMember() {
        //given
        final CreateMemberRequest request = new CreateMemberRequest();

        //when
        sut.createMember(request);

        //then
        Approvals.verify(new CreatedMemberExpect("홍길동","kildong@gmail.com","Bronze"));
    }

    private record CreatedMemberExpect(String name, String email, String level
    ){
    }

    private class MemberService {
        public void createMember(CreateMemberRequest request) {

        }
    }

    private class CreateMemberRequest {
    }
}
