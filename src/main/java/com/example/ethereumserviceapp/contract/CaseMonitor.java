package com.example.ethereumserviceapp.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.6.1.
 */
@SuppressWarnings("rawtypes")
public class CaseMonitor extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506110bc806100206000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c8063d36cf4a31161005b578063d36cf4a31461021a578063d4988c1514610315578063d840e7171461036e578063fb40c22a1461050c5761007d565b8063235f4c121461008257806345b10ce4146100c3578063bb98be4014610118575b600080fd5b6100c16004803603602081101561009857600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919050505061056b565b005b610102600480360360208110156100d957600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919050505061062f565b6040518082815260200191505060405180910390f35b6102046004803603608081101561012e57600080fd5b8101908080356fffffffffffffffffffffffffffffffff191690602001909291908035906020019064010000000081111561016857600080fd5b82018360208201111561017a57600080fd5b8035906020019184600183028401116401000000008311171561019c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080351515906020019092919080359060200190929190505050610672565b6040518082815260200191505060405180910390f35b610313600480360360a081101561023057600080fd5b8101908080356fffffffffffffffffffffffffffffffff191690602001909291908035906020019064010000000081111561026a57600080fd5b82018360208201111561027c57600080fd5b8035906020019184600183028401116401000000008311171561029e57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f82011690508083019250505050505050919291929080351515906020019092919080359060200190929190803560ff1690602001909291905050506108f5565b005b6103546004803603602081101561032b57600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610a1e565b604051808215151515815260200191505060405180910390f35b6103ad6004803603602081101561038457600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610aa6565b60405180886fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff191681526020018060200187151515158152602001868152602001806020018060200185600381111561040557fe5b60ff16815260200184810384528a818151815260200191508051906020019080838360005b8381101561044557808201518184015260208101905061042a565b50505050905090810190601f1680156104725780820380516001836020036101000a031916815260200191505b50848103835287818151815260200191508051906020019060200280838360005b838110156104ae578082015181840152602081019050610493565b50505050905001848103825286818151815260200191508051906020019060200280838360005b838110156104f05780820151818401526020810190506104d5565b505050509050019a505050505050505050505060405180910390f35b610514610cb9565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561055757808201518184015260208101905061053c565b505050509050019250505060405180910390f35b61057481610a1e565b61057d57600080fd5b60006105888261062f565b90506000818154811061059757fe5b9060005260206000209060070201600080820160006101000a8154906fffffffffffffffffffffffffffffffff02191690556001820160006105d99190610da5565b6002820160006101000a81549060ff021916905560038201600090556004820160006106059190610ded565b6005820160006106159190610e0e565b6006820160006101000a81549060ff021916905550505050565b600060016000836fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff19168152602001908152602001600020549050919050565b600061067d85610a1e565b1561068757600080fd5b606060016040519080825280602002602001820160405280156106b95781602001602082028038833980820191505090505b50905082816000815181106106ca57fe5b602002602001018181525050606060016040519080825280602002602001820160405280156107085781602001602082028038833980820191505090505b50905060008160008151811061071a57fe5b6020026020010190600381111561072d57fe5b9081600381111561073a57fe5b8152505060006040518060e00160405280896fffffffffffffffffffffffffffffffff1916815260200188815260200187151581526020018681526020018481526020018381526020016000600381111561079157fe5b8152509080600181540180825580915050906001820390600052602060002090600702016000909192909190915060008201518160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c0217905550602082015181600101908051906020019061080b929190610e36565b5060408201518160020160006101000a81548160ff021916908315150217905550606082015181600301556080820151816004019080519060200190610852929190610eb6565b5060a082015181600501908051906020019061086f929190610f03565b5060c08201518160060160006101000a81548160ff0219169083600381111561089457fe5b02179055505050506000600160008054905003905080600160008a6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff1916815260200190815260200160002081905550809350505050949350505050565b6108fe85610a1e565b61090757600080fd5b60006109128661062f565b9050600080828154811061092257fe5b906000526020600020906007020190508581600101908051906020019061094a929190610fb2565b50848160020160006101000a81548160ff021916908315150217905550838160030181905550806004018490806001815401808255809150509060018203906000526020600020016000909192909190915055508060050183908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff021916908360038111156109ea57fe5b021790555050828160060160006101000a81548160ff02191690836003811115610a1057fe5b021790555050505050505050565b6000806000805490501415610a365760009050610aa1565b816fffffffffffffffffffffffffffffffff19166000610a558461062f565b81548110610a5f57fe5b906000526020600020906007020160000160009054906101000a900460801b6fffffffffffffffffffffffffffffffff19161415610aa05760019050610aa1565b5b919050565b600060606000806060806000610abb88610a1e565b610ac457600080fd5b600080610ad08a61062f565b81548110610ada57fe5b906000526020600020906007020190508060000160009054906101000a900460801b816001018260020160009054906101000a900460ff16836003015484600401856005018660060160009054906101000a900460ff16858054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bc65780601f10610b9b57610100808354040283529160200191610bc6565b820191906000526020600020905b815481529060010190602001808311610ba957829003601f168201915b5050505050955082805480602002602001604051908101604052809291908181526020018280548015610c1857602002820191906000526020600020905b815481526020019060010190808311610c04575b5050505050925081805480602002602001604051908101604052809291908181526020018280548015610c9857602002820191906000526020600020906000905b82829054906101000a900460ff166003811115610c7257fe5b81526020019060010190602082600001049283019260010382029150808411610c595790505b50505050509150975097509750975097509750975050919395979092949650565b606080600080549050604051908082528060200260200182016040528015610cf05781602001602082028038833980820191505090505b509050600080805490501115610d9e5760008090506000808054905090505b6000811115610d9b5760006001820381548110610d2857fe5b906000526020600020906007020160000160009054906101000a900460801b838380600101945081518110610d5957fe5b60200260200101906fffffffffffffffffffffffffffffffff191690816fffffffffffffffffffffffffffffffff191681525050808060019003915050610d0f565b50505b8091505090565b50805460018160011615610100020316600290046000825580601f10610dcb5750610dea565b601f016020900490600052602060002090810190610de99190611032565b5b50565b5080546000825590600052602060002090810190610e0b9190611032565b50565b50805460008255601f016020900490600052602060002090810190610e339190611032565b50565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610e7757805160ff1916838001178555610ea5565b82800160010185558215610ea5579182015b82811115610ea4578251825591602001919060010190610e89565b5b509050610eb29190611032565b5090565b828054828255906000526020600020908101928215610ef2579160200282015b82811115610ef1578251825591602001919060010190610ed6565b5b509050610eff9190611032565b5090565b82805482825590600052602060002090601f01602090048101928215610fa15791602002820160005b83821115610f7257835183826101000a81548160ff02191690836003811115610f5157fe5b02179055509260200192600101602081600001049283019260010302610f2c565b8015610f9f5782816101000a81549060ff0219169055600101602081600001049283019260010302610f72565b505b509050610fae9190611057565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610ff357805160ff1916838001178555611021565b82800160010185558215611021579182015b82811115611020578251825591602001919060010190611005565b5b50905061102e9190611032565b5090565b61105491905b80821115611050576000816000905550600101611038565b5090565b90565b61108491905b8082111561108057600081816101000a81549060ff02191690555060010161105d565b5090565b9056fea265627a7a72315820b22607199cf0fe446d3fd7eaffd9158b3f365417b1ee6b2a486df826a80b486a64736f6c63430005100032";

    public static final String FUNC__GETCASEINDEX = "_getCaseIndex";

    public static final String FUNC_ADDCASE = "addCase";

    public static final String FUNC_UPDATECASE = "updateCase";

    public static final String FUNC_CASEEXISTS = "caseExists";

    public static final String FUNC_GETALLCASES = "getAllCases";

    public static final String FUNC_GETCASE = "getCase";

    public static final String FUNC_DELETECASE = "deleteCase";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0x3a69e747f6BEC341cDe8F10A996f4E2375b61879");
        _addresses.put("5777", "0x05FA7e50Ba5EE9E4324014B46a475CCCC1d85875");
    }

    @Deprecated
    protected CaseMonitor(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CaseMonitor(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CaseMonitor(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CaseMonitor(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> _getCaseIndex(byte[] _uuid) {
        final Function function = new Function(FUNC__GETCASEINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addCase(byte[] _uuid, String _caseName, Boolean _isStudent, BigInteger _date) {
        final Function function = new Function(
                FUNC_ADDCASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.Utf8String(_caseName), 
                new org.web3j.abi.datatypes.Bool(_isStudent), 
                new org.web3j.abi.datatypes.generated.Uint256(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateCase(byte[] _uuid, String _caseName, Boolean _isStudent, BigInteger _date, BigInteger _state) {
        final Function function = new Function(
                FUNC_UPDATECASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.Utf8String(_caseName), 
                new org.web3j.abi.datatypes.Bool(_isStudent), 
                new org.web3j.abi.datatypes.generated.Uint256(_date), 
                new org.web3j.abi.datatypes.generated.Uint8(_state)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> caseExists(byte[] _uuid) {
        final Function function = new Function(FUNC_CASEEXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<List> getAllCases() {
        final Function function = new Function(FUNC_GETALLCASES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes16>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple7<byte[], String, Boolean, BigInteger, List<BigInteger>, List<BigInteger>, BigInteger>> getCase(byte[] _uuid) {
        final Function function = new Function(FUNC_GETCASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes16>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple7<byte[], String, Boolean, BigInteger, List<BigInteger>, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple7<byte[], String, Boolean, BigInteger, List<BigInteger>, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple7<byte[], String, Boolean, BigInteger, List<BigInteger>, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<byte[], String, Boolean, BigInteger, List<BigInteger>, List<BigInteger>, BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (Boolean) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                convertToNative((List<Uint256>) results.get(4).getValue()), 
                                convertToNative((List<Uint8>) results.get(5).getValue()), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> deleteCase(byte[] _uuid) {
        final Function function = new Function(
                FUNC_DELETECASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CaseMonitor load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CaseMonitor(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CaseMonitor load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CaseMonitor(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CaseMonitor load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CaseMonitor(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CaseMonitor load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CaseMonitor(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CaseMonitor> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CaseMonitor.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CaseMonitor> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CaseMonitor.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CaseMonitor> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CaseMonitor.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CaseMonitor> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CaseMonitor.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
