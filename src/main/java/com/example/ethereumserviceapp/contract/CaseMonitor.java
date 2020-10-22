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
import org.web3j.abi.datatypes.generated.Bytes16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple9;
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
    public static final String BINARY = "0x608060405234801561001057600080fd5b506118b8806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063d4988c151161005b578063d4988c15146101e7578063d840e71714610240578063ea02882014610446578063fb40c22a146104a557610088565b8063195a00a41461008d578063235f4c12146100ef57806345b10ce41461013057806377c4327f14610185575b600080fd5b6100ed600480360360808110156100a357600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190803560ff1690602001909291908035906020019092919080359060200190929190505050610504565b005b61012e6004803603602081101561010557600080fd5b8101908080356fffffffffffffffffffffffffffffffff191690602001909291905050506106ab565b005b61016f6004803603602081101561014657600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610cbe565b6040518082815260200191505060405180910390f35b6101e56004803603608081101561019b57600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919080359060200190929190803560ff16906020019092919080359060200190929190505050610d01565b005b610226600480360360208110156101fd57600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610dfd565b604051808215151515815260200191505060405180910390f35b61027f6004803603602081101561025657600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610e85565b604051808a6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff1916815260200189815260200180602001806020018860058111156102c957fe5b60ff16815260200180602001806020018060200187815260200186810386528d818151815260200191508051906020019060200280838360005b8381101561031e578082015181840152602081019050610303565b5050505090500186810385528c818151815260200191508051906020019060200280838360005b83811015610360578082015181840152602081019050610345565b5050505090500186810384528a818151815260200191508051906020019060200280838360005b838110156103a2578082015181840152602081019050610387565b50505050905001868103835289818151815260200191508051906020019060200280838360005b838110156103e45780820151818401526020810190506103c9565b50505050905001868103825288818151815260200191508051906020019060200280838360005b8381101561042657808201518184015260208101905061040b565b505050509050019e50505050505050505050505050505060405180910390f35b61048f6004803603604081101561045c57600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919080359060200190929190505050611124565b6040518082815260200191505060405180910390f35b6104ad6114e1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104f05780820151818401526020810190506104d5565b505050509050019250505060405180910390f35b61050d84610dfd565b61051657600080fd5b600061052185610cbe565b9050600080828154811061053157fe5b9060005260206000209060090201905060008160050160008154811061055357fe5b906000526020600020015414156105ea57838160050160008154811061057557fe5b9060005260206000200181905550828160060160008154811061059457fe5b906000526020600020018190555084816007016000815481106105b357fe5b90600052602060002090602091828204019190066101000a81548160ff021916908360058111156105e057fe5b0217905550610699565b80600501849080600181540180825580915050906001820390600052602060002001600090919290919091505550806006018390806001815401808255809150509060018203906000526020600020016000909192909190915055508060070185908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff0219169083600581111561069257fe5b0217905550505b60008160080181905550505050505050565b6106b481610dfd565b6106bd57600080fd5b60006106c882610cbe565b90506001600080549050038114610bff576106e16115cd565b600082815481106106ee57fe5b9060005260206000209060090201604051806101200160405290816000820160009054906101000a900460801b6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff19168152602001600182015481526020016002820180548060200260200160405190810160405280929190818152602001828054801561079e57602002820191906000526020600020905b81548152602001906001019080831161078a575b505050505081526020016003820180548060200260200160405190810160405280929190818152602001828054801561082457602002820191906000526020600020906000905b82829054906101000a900460ff1660058111156107fe57fe5b815260200190600101906020826000010492830192600103820291508084116107e55790505b505050505081526020016004820160009054906101000a900460ff16600581111561084b57fe5b600581111561085657fe5b8152602001600582018054806020026020016040519081016040528092919081815260200182805480156108a957602002820191906000526020600020905b815481526020019060010190808311610895575b505050505081526020016006820180548060200260200160405190810160405280929190818152602001828054801561090157602002820191906000526020600020905b8154815260200190600101908083116108ed575b505050505081526020016007820180548060200260200160405190810160405280929190818152602001828054801561098757602002820191906000526020600020906000905b82829054906101000a900460ff16600581111561096157fe5b815260200190600101906020826000010492830192600103820291508084116109485790505b5050505050815260200160088201548152505090506000600160008054905003815481106109b157fe5b9060005260206000209060090201600083815481106109cc57fe5b90600052602060002090600902016000820160009054906101000a900460801b8160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c0217905550600182015481600101556002820181600201908054610a37929190611637565b506003820181600301908054610a4e929190611689565b506004820160009054906101000a900460ff168160040160006101000a81548160ff02191690836005811115610a8057fe5b02179055506005820181600501908054610a9b929190611637565b506006820181600601908054610ab2929190611637565b506007820181600701908054610ac9929190611689565b506008820154816008015590505080600060016000805490500381548110610aed57fe5b906000526020600020906009020160008201518160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c0217905550602082015181600101556040820151816002019080519060200190610b519291906116e9565b506060820151816003019080519060200190610b6e929190611736565b5060808201518160040160006101000a81548160ff02191690836005811115610b9357fe5b021790555060a0820151816005019080519060200190610bb49291906116e9565b5060c0820151816006019080519060200190610bd19291906116e9565b5060e0820151816007019080519060200190610bee929190611736565b506101008201518160080155905050505b6000805480610c0a57fe5b6001900381819060005260206000209060090201600080820160006101000a8154906fffffffffffffffffffffffffffffffff02191690556001820160009055600282016000610c5a91906117e5565b600382016000610c6a9190611806565b6004820160006101000a81549060ff0219169055600582016000610c8e91906117e5565b600682016000610c9e91906117e5565b600782016000610cae9190611806565b6008820160009055505090555050565b600060016000836fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff19168152602001908152602001600020549050919050565b610d0a84610dfd565b610d1357600080fd5b6000610d1e85610cbe565b90506000808281548110610d2e57fe5b90600052602060002090600902019050848160010181905550806002018590806001815401808255809150509060018203906000526020600020016000909192909190915055508060030184908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff02191690836005811115610dc157fe5b021790555050838160040160006101000a81548160ff02191690836005811115610de757fe5b0217905550828160080181905550505050505050565b6000806000805490501415610e155760009050610e80565b816fffffffffffffffffffffffffffffffff19166000610e3484610cbe565b81548110610e3e57fe5b906000526020600020906009020160000160009054906101000a900460801b6fffffffffffffffffffffffffffffffff19161415610e7f5760019050610e80565b5b919050565b600080606080600060608060606000610e9d8a610dfd565b610ea657600080fd5b600080610eb28c610cbe565b81548110610ebc57fe5b906000526020600020906009020190508060000160009054906101000a900460801b816001015482600201836003018460040160009054906101000a900460ff16856005018660060187600701886008015486805480602002602001604051908101604052809291908181526020018280548015610f5957602002820191906000526020600020905b815481526020019060010190808311610f45575b5050505050965085805480602002602001604051908101604052809291908181526020018280548015610fd957602002820191906000526020600020906000905b82829054906101000a900460ff166005811115610fb357fe5b81526020019060010190602082600001049283019260010382029150808411610f9a5790505b505050505095508380548060200260200160405190810160405280929190818152602001828054801561102b57602002820191906000526020600020905b815481526020019060010190808311611017575b505050505093508280548060200260200160405190810160405280929190818152602001828054801561107d57602002820191906000526020600020905b815481526020019060010190808311611069575b50505050509250818054806020026020016040519081016040528092919081815260200182805480156110fd57602002820191906000526020600020906000905b82829054906101000a900460ff1660058111156110d757fe5b815260200190600101906020826000010492830192600103820291508084116110be5790505b50505050509150995099509950995099509950995099509950509193959799909294969850565b600061112f83610dfd565b1561113957600080fd5b6060600160405190808252806020026020018201604052801561116b5781602001602082028038833980820191505090505b509050828160008151811061117c57fe5b602002602001018181525050606060016040519080825280602002602001820160405280156111ba5781602001602082028038833980820191505090505b5090506000816000815181106111cc57fe5b602002602001019060058111156111df57fe5b908160058111156111ec57fe5b81525050606060016040519080825280602002602001820160405280156112225781602001602082028038833980820191505090505b50905060008160008151811061123457fe5b602002602001018181525050606060016040519080825280602002602001820160405280156112725781602001602082028038833980820191505090505b50905060008160008151811061128457fe5b602002602001018181525050606060016040519080825280602002602001820160405280156112c25781602001602082028038833980820191505090505b5090506000816000815181106112d457fe5b602002602001019060058111156112e757fe5b908160058111156112f457fe5b8152505060006040518061012001604052808a6fffffffffffffffffffffffffffffffff191681526020018981526020018781526020018681526020016000600581111561133e57fe5b815260200185815260200184815260200183815260200160008152509080600181540180825580915050906001820390600052602060002090600902016000909192909190915060008201518160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c02179055506020820151816001015560408201518160020190805190602001906113db9291906116e9565b5060608201518160030190805190602001906113f8929190611736565b5060808201518160040160006101000a81548160ff0219169083600581111561141d57fe5b021790555060a082015181600501908051906020019061143e9291906116e9565b5060c082015181600601908051906020019061145b9291906116e9565b5060e0820151816007019080519060200190611478929190611736565b5061010082015181600801555050506000600160008054905003905080600160008b6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff191681526020019081526020016000208190555080965050505050505092915050565b6060806000805490506040519080825280602002602001820160405280156115185781602001602082028038833980820191505090505b5090506000808054905011156115c65760008090506000808054905090505b60008111156115c3576000600182038154811061155057fe5b906000526020600020906009020160000160009054906101000a900460801b83838060010194508151811061158157fe5b60200260200101906fffffffffffffffffffffffffffffffff191690816fffffffffffffffffffffffffffffffff191681525050808060019003915050611537565b50505b8091505090565b60405180610120016040528060006fffffffffffffffffffffffffffffffff191681526020016000815260200160608152602001606081526020016000600581111561161557fe5b8152602001606081526020016060815260200160608152602001600081525090565b8280548282559060005260206000209081019282156116785760005260206000209182015b8281111561167757825482559160010191906001019061165c565b5b509050611685919061182e565b5090565b82805482825590600052602060002090601f016020900481019282156116d857600052602060002091601f016020900482015b828111156116d75782548255916001019190600101906116bc565b5b5090506116e59190611853565b5090565b828054828255906000526020600020908101928215611725579160200282015b82811115611724578251825591602001919060010190611709565b5b509050611732919061182e565b5090565b82805482825590600052602060002090601f016020900481019282156117d45791602002820160005b838211156117a557835183826101000a81548160ff0219169083600581111561178457fe5b0217905550926020019260010160208160000104928301926001030261175f565b80156117d25782816101000a81549060ff02191690556001016020816000010492830192600103026117a5565b505b5090506117e19190611853565b5090565b5080546000825590600052602060002090810190611803919061182e565b50565b50805460008255601f01602090049060005260206000209081019061182b919061182e565b50565b61185091905b8082111561184c576000816000905550600101611834565b5090565b90565b61188091905b8082111561187c57600081816101000a81549060ff021916905550600101611859565b5090565b9056fea265627a7a7231582045dbdb07697e320f47194f3a496ba6809e5e779e55696887629d916eeb71aaa764736f6c63430005100032";

    public static final String FUNC__GETCASEINDEX = "_getCaseIndex";

    public static final String FUNC_ADDCASE = "addCase";

    public static final String FUNC_UPDATECASE = "updateCase";

    public static final String FUNC_ADDPAYMENT = "addPayment";

    public static final String FUNC_CASEEXISTS = "caseExists";

    public static final String FUNC_GETALLCASES = "getAllCases";

    public static final String FUNC_GETCASE = "getCase";

    public static final String FUNC_DELETECASE = "deleteCase";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0x4bb7774e8e1bb6Fde871bdb9a4b48A45b9C0CE34");
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

    public RemoteFunctionCall<TransactionReceipt> addCase(byte[] _uuid, BigInteger _date) {
        final Function function = new Function(
                FUNC_ADDCASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.generated.Uint256(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updateCase(byte[] _uuid, BigInteger _date, BigInteger _state, BigInteger _offset) {
        final Function function = new Function(
                FUNC_UPDATECASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.generated.Uint256(_date), 
                new org.web3j.abi.datatypes.generated.Uint8(_state), 
                new org.web3j.abi.datatypes.generated.Uint256(_offset)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addPayment(byte[] _uuid, BigInteger _state, BigInteger _pDate, BigInteger _payHistory) {
        final Function function = new Function(
                FUNC_ADDPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.generated.Uint8(_state), 
                new org.web3j.abi.datatypes.generated.Uint256(_pDate), 
                new org.web3j.abi.datatypes.generated.Uint256(_payHistory)), 
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

    public RemoteFunctionCall<Tuple9<byte[], BigInteger, List<BigInteger>, List<BigInteger>, BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>, BigInteger>> getCase(byte[] _uuid) {
        final Function function = new Function(FUNC_GETCASE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes16>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<Uint8>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple9<byte[], BigInteger, List<BigInteger>, List<BigInteger>, BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple9<byte[], BigInteger, List<BigInteger>, List<BigInteger>, BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple9<byte[], BigInteger, List<BigInteger>, List<BigInteger>, BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<byte[], BigInteger, List<BigInteger>, List<BigInteger>, BigInteger, List<BigInteger>, List<BigInteger>, List<BigInteger>, BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                convertToNative((List<Uint8>) results.get(3).getValue()), 
                                (BigInteger) results.get(4).getValue(), 
                                convertToNative((List<Uint256>) results.get(5).getValue()), 
                                convertToNative((List<Uint256>) results.get(6).getValue()), 
                                convertToNative((List<Uint8>) results.get(7).getValue()), 
                                (BigInteger) results.get(8).getValue());
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
