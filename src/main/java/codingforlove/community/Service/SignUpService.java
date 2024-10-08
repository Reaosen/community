package codingforlove.community.Service;

import codingforlove.community.DTO.UndefinedUserDTO;

public interface SignUpService {
    String insertEmailCode(UndefinedUserDTO email);

    void codeCompare(UndefinedUserDTO signUpDTO);

    void insert(UndefinedUserDTO signUpDTO);
}
