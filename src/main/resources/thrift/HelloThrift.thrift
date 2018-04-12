namespace java org.kxw.bms.thrift

service HelloThrift {

    string helloString(1:string param)

    i32 helloInt(1:i32 param)

    bool helloBool(1:bool param)

    void helloVoid();

    string helloNull();
}