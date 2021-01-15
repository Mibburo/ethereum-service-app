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
    public static final String BINARY = "0x608060405234801561001057600080fd5b506118c2806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063d4988c151161005b578063d4988c15146101f1578063d840e7171461024a578063ea02882014610450578063fb40c22a146104af57610088565b8063235f4c121461008d57806345b10ce4146100ce57806356066bed1461012357806377c4327f1461018f575b600080fd5b6100cc600480360360208110156100a357600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919050505061050e565b005b61010d600480360360208110156100e457600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610b21565b6040518082815260200191505060405180910390f35b61018d600480360360a081101561013957600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190803560ff169060200190929190803590602001909291908035906020019092919080359060200190929190505050610b64565b005b6101ef600480360360808110156101a557600080fd5b8101908080356fffffffffffffffffffffffffffffffff1916906020019092919080359060200190929190803560ff16906020019092919080359060200190929190505050610d0b565b005b6102306004803603602081101561020757600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610e07565b604051808215151515815260200191505060405180910390f35b6102896004803603602081101561026057600080fd5b8101908080356fffffffffffffffffffffffffffffffff19169060200190929190505050610e8f565b604051808a6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff1916815260200189815260200180602001806020018860068111156102d357fe5b60ff16815260200180602001806020018060200187815260200186810386528d818151815260200191508051906020019060200280838360005b8381101561032857808201518184015260208101905061030d565b5050505090500186810385528c818151815260200191508051906020019060200280838360005b8381101561036a57808201518184015260208101905061034f565b5050505090500186810384528a818151815260200191508051906020019060200280838360005b838110156103ac578082015181840152602081019050610391565b50505050905001868103835289818151815260200191508051906020019060200280838360005b838110156103ee5780820151818401526020810190506103d3565b50505050905001868103825288818151815260200191508051906020019060200280838360005b83811015610430578082015181840152602081019050610415565b505050509050019e50505050505050505050505050505060405180910390f35b6104996004803603604081101561046657600080fd5b8101908080356fffffffffffffffffffffffffffffffff191690602001909291908035906020019092919050505061112e565b6040518082815260200191505060405180910390f35b6104b76114eb565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104fa5780820151818401526020810190506104df565b505050509050019250505060405180910390f35b61051781610e07565b61052057600080fd5b600061052b82610b21565b90506001600080549050038114610a62576105446115d7565b6000828154811061055157fe5b9060005260206000209060090201604051806101200160405290816000820160009054906101000a900460801b6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff19168152602001600182015481526020016002820180548060200260200160405190810160405280929190818152602001828054801561060157602002820191906000526020600020905b8154815260200190600101908083116105ed575b505050505081526020016003820180548060200260200160405190810160405280929190818152602001828054801561068757602002820191906000526020600020906000905b82829054906101000a900460ff16600681111561066157fe5b815260200190600101906020826000010492830192600103820291508084116106485790505b505050505081526020016004820160009054906101000a900460ff1660068111156106ae57fe5b60068111156106b957fe5b81526020016005820180548060200260200160405190810160405280929190818152602001828054801561070c57602002820191906000526020600020905b8154815260200190600101908083116106f8575b505050505081526020016006820180548060200260200160405190810160405280929190818152602001828054801561076457602002820191906000526020600020905b815481526020019060010190808311610750575b50505050508152602001600782018054806020026020016040519081016040528092919081815260200182805480156107ea57602002820191906000526020600020906000905b82829054906101000a900460ff1660068111156107c457fe5b815260200190600101906020826000010492830192600103820291508084116107ab5790505b50505050508152602001600882015481525050905060006001600080549050038154811061081457fe5b90600052602060002090600902016000838154811061082f57fe5b90600052602060002090600902016000820160009054906101000a900460801b8160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c021790555060018201548160010155600282018160020190805461089a929190611641565b5060038201816003019080546108b1929190611693565b506004820160009054906101000a900460ff168160040160006101000a81548160ff021916908360068111156108e357fe5b021790555060058201816005019080546108fe929190611641565b506006820181600601908054610915929190611641565b50600782018160070190805461092c929190611693565b50600882015481600801559050508060006001600080549050038154811061095057fe5b906000526020600020906009020160008201518160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c02179055506020820151816001015560408201518160020190805190602001906109b49291906116f3565b5060608201518160030190805190602001906109d1929190611740565b5060808201518160040160006101000a81548160ff021916908360068111156109f657fe5b021790555060a0820151816005019080519060200190610a179291906116f3565b5060c0820151816006019080519060200190610a349291906116f3565b5060e0820151816007019080519060200190610a51929190611740565b506101008201518160080155905050505b6000805480610a6d57fe5b6001900381819060005260206000209060090201600080820160006101000a8154906fffffffffffffffffffffffffffffffff02191690556001820160009055600282016000610abd91906117ef565b600382016000610acd9190611810565b6004820160006101000a81549060ff0219169055600582016000610af191906117ef565b600682016000610b0191906117ef565b600782016000610b119190611810565b6008820160009055505090555050565b600060016000836fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff19168152602001908152602001600020549050919050565b610b6d85610e07565b610b7657600080fd5b6000610b8186610b21565b90506000808281548110610b9157fe5b90600052602060002090600902019050600081600501600081548110610bb357fe5b90600052602060002001541415610c4a578481600501600081548110610bd557fe5b90600052602060002001819055508381600601600081548110610bf457fe5b90600052602060002001819055508581600701600081548110610c1357fe5b90600052602060002090602091828204019190066101000a81548160ff02191690836006811115610c4057fe5b0217905550610cf9565b80600501859080600181540180825580915050906001820390600052602060002001600090919290919091505550806006018490806001815401808255809150509060018203906000526020600020016000909192909190915055508060070186908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff02191690836006811115610cf257fe5b0217905550505b82816008018190555050505050505050565b610d1484610e07565b610d1d57600080fd5b6000610d2885610b21565b90506000808281548110610d3857fe5b90600052602060002090600902019050848160010181905550806002018590806001815401808255809150509060018203906000526020600020016000909192909190915055508060030184908060018154018082558091505090600182039060005260206000209060209182820401919006909192909190916101000a81548160ff02191690836006811115610dcb57fe5b021790555050838160040160006101000a81548160ff02191690836006811115610df157fe5b0217905550828160080181905550505050505050565b6000806000805490501415610e1f5760009050610e8a565b816fffffffffffffffffffffffffffffffff19166000610e3e84610b21565b81548110610e4857fe5b906000526020600020906009020160000160009054906101000a900460801b6fffffffffffffffffffffffffffffffff19161415610e895760019050610e8a565b5b919050565b600080606080600060608060606000610ea78a610e07565b610eb057600080fd5b600080610ebc8c610b21565b81548110610ec657fe5b906000526020600020906009020190508060000160009054906101000a900460801b816001015482600201836003018460040160009054906101000a900460ff16856005018660060187600701886008015486805480602002602001604051908101604052809291908181526020018280548015610f6357602002820191906000526020600020905b815481526020019060010190808311610f4f575b5050505050965085805480602002602001604051908101604052809291908181526020018280548015610fe357602002820191906000526020600020906000905b82829054906101000a900460ff166006811115610fbd57fe5b81526020019060010190602082600001049283019260010382029150808411610fa45790505b505050505095508380548060200260200160405190810160405280929190818152602001828054801561103557602002820191906000526020600020905b815481526020019060010190808311611021575b505050505093508280548060200260200160405190810160405280929190818152602001828054801561108757602002820191906000526020600020905b815481526020019060010190808311611073575b505050505092508180548060200260200160405190810160405280929190818152602001828054801561110757602002820191906000526020600020906000905b82829054906101000a900460ff1660068111156110e157fe5b815260200190600101906020826000010492830192600103820291508084116110c85790505b50505050509150995099509950995099509950995099509950509193959799909294969850565b600061113983610e07565b1561114357600080fd5b606060016040519080825280602002602001820160405280156111755781602001602082028038833980820191505090505b509050828160008151811061118657fe5b602002602001018181525050606060016040519080825280602002602001820160405280156111c45781602001602082028038833980820191505090505b5090506000816000815181106111d657fe5b602002602001019060068111156111e957fe5b908160068111156111f657fe5b815250506060600160405190808252806020026020018201604052801561122c5781602001602082028038833980820191505090505b50905060008160008151811061123e57fe5b6020026020010181815250506060600160405190808252806020026020018201604052801561127c5781602001602082028038833980820191505090505b50905060008160008151811061128e57fe5b602002602001018181525050606060016040519080825280602002602001820160405280156112cc5781602001602082028038833980820191505090505b5090506000816000815181106112de57fe5b602002602001019060068111156112f157fe5b908160068111156112fe57fe5b8152505060006040518061012001604052808a6fffffffffffffffffffffffffffffffff191681526020018981526020018781526020018681526020016000600681111561134857fe5b815260200185815260200184815260200183815260200160008152509080600181540180825580915050906001820390600052602060002090600902016000909192909190915060008201518160000160006101000a8154816fffffffffffffffffffffffffffffffff021916908360801c02179055506020820151816001015560408201518160020190805190602001906113e59291906116f3565b506060820151816003019080519060200190611402929190611740565b5060808201518160040160006101000a81548160ff0219169083600681111561142757fe5b021790555060a08201518160050190805190602001906114489291906116f3565b5060c08201518160060190805190602001906114659291906116f3565b5060e0820151816007019080519060200190611482929190611740565b5061010082015181600801555050506000600160008054905003905080600160008b6fffffffffffffffffffffffffffffffff19166fffffffffffffffffffffffffffffffff191681526020019081526020016000208190555080965050505050505092915050565b6060806000805490506040519080825280602002602001820160405280156115225781602001602082028038833980820191505090505b5090506000808054905011156115d05760008090506000808054905090505b60008111156115cd576000600182038154811061155a57fe5b906000526020600020906009020160000160009054906101000a900460801b83838060010194508151811061158b57fe5b60200260200101906fffffffffffffffffffffffffffffffff191690816fffffffffffffffffffffffffffffffff191681525050808060019003915050611541565b50505b8091505090565b60405180610120016040528060006fffffffffffffffffffffffffffffffff191681526020016000815260200160608152602001606081526020016000600681111561161f57fe5b8152602001606081526020016060815260200160608152602001600081525090565b8280548282559060005260206000209081019282156116825760005260206000209182015b82811115611681578254825591600101919060010190611666565b5b50905061168f9190611838565b5090565b82805482825590600052602060002090601f016020900481019282156116e257600052602060002091601f016020900482015b828111156116e15782548255916001019190600101906116c6565b5b5090506116ef919061185d565b5090565b82805482825590600052602060002090810192821561172f579160200282015b8281111561172e578251825591602001919060010190611713565b5b50905061173c9190611838565b5090565b82805482825590600052602060002090601f016020900481019282156117de5791602002820160005b838211156117af57835183826101000a81548160ff0219169083600681111561178e57fe5b02179055509260200192600101602081600001049283019260010302611769565b80156117dc5782816101000a81549060ff02191690556001016020816000010492830192600103026117af565b505b5090506117eb919061185d565b5090565b508054600082559060005260206000209081019061180d9190611838565b50565b50805460008255601f0160209004906000526020600020908101906118359190611838565b50565b61185a91905b8082111561185657600081600090555060010161183e565b5090565b90565b61188a91905b8082111561188657600081816101000a81549060ff021916905550600101611863565b5090565b9056fea265627a7a72315820409bd15f4145fe9842414b2566eed8997093ec5cc93570c6893775797fc5c57564736f6c63430005100032";

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
        _addresses.put("2018", "0xc8305EbbA9FCCFCfe95cf6a7B7c17C9dDf1620AE");
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

    public RemoteFunctionCall<TransactionReceipt> addPayment(byte[] _uuid, BigInteger _state, BigInteger _pDate, BigInteger _payHistory, BigInteger _offset) {
        final Function function = new Function(
                FUNC_ADDPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes16(_uuid), 
                new org.web3j.abi.datatypes.generated.Uint8(_state), 
                new org.web3j.abi.datatypes.generated.Uint256(_pDate), 
                new org.web3j.abi.datatypes.generated.Uint256(_payHistory), 
                new org.web3j.abi.datatypes.generated.Uint256(_offset)), 
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
