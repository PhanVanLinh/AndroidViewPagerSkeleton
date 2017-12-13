# AndroidViewPagerSkeleton

See final skeleton in https://github.com/PhanVanLinh/AndroidViewPagerSkeleton/tree/Final-Skeleton

## Model

#### MainActivity
```
- ContainerFragment1 -> (Fragment1) -> (Fragment1sub1) -> (Fragment1sub2)
- ContainerFragment2 -> (Fragment2)
- ContainerFragment3 -> (Fragment3) -> (Fragment3sub1)
  + Fragment3A -> Fragment3Asub1
  + Fragment3B
  + Fragment3C
- ContainerFragment4 -> Fragment4
- ContainerFragment5 -> Fragment5
```
#### SecondActivity

### Init nested viewpager only when fragment visible



### Open Activity
```
ContainerFragment1: setUserVisibleHint isVisibleToUser:false - isResumed:false
ContainerFragment2: setUserVisibleHint isVisibleToUser:false - isResumed:false
ContainerFragment3: setUserVisibleHint isVisibleToUser:false - isResumed:false
ContainerFragment4: setUserVisibleHint isVisibleToUser:false - isResumed:false
ContainerFragment5: setUserVisibleHint isVisibleToUser:false - isResumed:false
ContainerFragment1: setUserVisibleHint isVisibleToUser:true - isResumed:false
ContainerFragment1: onAttach
Fragment1: onAttach
ContainerFragment2: onAttach
Fragment2: onAttach
ContainerFragment3: onAttach
Fragment3: onAttach
ContainerFragment4: onAttach
Fragment4: onAttach
ContainerFragment5: onAttach
Fragment5: onAttach
ContainerFragment1: onCreateView
Fragment1: onCreateView
Fragment1: onViewCreated
Fragment1: onCreateAnimation enter:true
ContainerFragment1: onStart
Fragment1: onStart
ContainerFragment1: onResume
Fragment1: onResume
ContainerFragment2: onCreateView
Fragment2: onCreateView
Fragment2: onViewCreated
Fragment2: onCreateAnimation enter:true
ContainerFragment3: onCreateView
Fragment3: onCreateView
Fragment3: onViewCreated
Fragment3: onCreateAnimation enter:true
ContainerFragment4: onCreateView
Fragment4: onCreateView
Fragment4: onViewCreated
Fragment4: onCreateAnimation enter:true
ContainerFragment5: onCreateView
Fragment5: onCreateView
Fragment5: onViewCreated
Fragment5: onCreateAnimation enter:true
ContainerFragment2: onStart
Fragment2: onStart
ContainerFragment2: onResume
Fragment2: onResume
ContainerFragment3: onStart
Fragment3: onStart
ContainerFragment3: onResume
Fragment3: onResume
ContainerFragment4: onStart
Fragment4: onStart
ContainerFragment4: onResume
Fragment4: onResume
ContainerFragment5: onStart
Fragment5: onStart
ContainerFragment5: onResume
Fragment5: onResume
```
### From Fragment1 go to Fragment1sub1
```
Fragment1sub1: onAttach
Fragment1: onStop
Fragment1: onDestroyView
Fragment1: onCreateAnimation enter:false
Fragment1sub1: onCreateView
Fragment1sub1: onViewCreated
Fragment1sub1: onCreateViewCreated
Fragment1sub1: onStart
Fragment1sub1: onResume
Fragment1sub1: onCreateAnimation enter:true
```
### Go back to Fragment1
```
Fragment1sub1: onStop
Fragment1sub1: onDestroyView
Fragment1sub1: onCreateAnimation enter:false
Fragment1: onCreateView
Fragment1: onViewCreated
Fragment1: onStart
Fragment1: onResume
Fragment1: onCreateAnimation enter:true
Fragment1sub1: onDestroy
```
### From Fragment1 go to Fragment2
```
ContainerFragment1: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment1: setUserVisibleHint isVisibleToUser:false - isResumed:true
ContainerFragment2: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment2: setUserVisibleHint isVisibleToUser:true - isResumed:true
```
### From Fragment2 go to Fragment3
```
ContainerFragment2: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment2: setUserVisibleHint isVisibleToUser:false - isResumed:true
ContainerFragment3: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3a: setUserVisibleHint isVisibleToUser:false - isResumed:false
Fragment3b: setUserVisibleHint isVisibleToUser:false - isResumed:false
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:false
Fragment3a: onAttach
Fragment3b: onAttach
Fragment3a: onCreateView
Fragment3a: onStart
Fragment3a: onResume
Fragment3b: onCreateView
Fragment3b: onStart
Fragment3b: onResume
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:true
```
### From Fragment3 go to Fragment3sub1
```
Fragment3sub1: onAttach
Fragment3a: onStop
Fragment3b: onStop
Fragment3: onStop
Fragment3a: onDestroyView
Fragment3b: onDestroyView
Fragment3: onDestroyView
Fragment3: onDestroyView
Fragment3: onCreateAnimation enter:false
Fragment3sub1: onCreateView
Fragment3sub1: onViewCreated
Fragment3sub1: onStart
Fragment3sub1: onResume
Fragment3sub1: onCreateAnimation enter:true
```
### From Fragment3sub1 go back to Fragment3
```
Fragment3sub1: onStop
Fragment3sub1: onDestroyView
Fragment3sub1: onCreateAnimation enter:false
Fragment3sub1: onDestroy
Fragment3: onCreateView
Fragment3: onViewCreated
Fragment3a: onCreateView
Fragment3b: onCreateView
Fragment3: onStart
Fragment3a: onStart
Fragment3b: onStart
Fragment3: onResume
Fragment3a: onResume
Fragment3b: onResume
Fragment3: onCreateAnimation enter:true
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:true
```
### In Fragment3A go to Fragment3Asub1
```
Fragment3aSub1: onAttach
Fragment3a: onStop
Fragment3b: onStop
Fragment3: onStop
Fragment3a: onDestroyView
Fragment3b: onDestroyView
Fragment3: onDestroyView
Fragment3: onDestroyView
Fragment3: onCreateAnimation enter:false
Fragment3aSub1: onCreateView
Fragment3aSub1: onViewCreated
Fragment3aSub1: onStart
Fragment3aSub1: onResume
Fragment3aSub1: onCreateAnimation enter:true
```
### In Fragment3Asub1 go back to Fragment3A
```
Fragment3aSub1: onAttach
Fragment3a: onStop
Fragment3b: onStop
Fragment3: onStop
Fragment3a: onDestroyView
Fragment3b: onDestroyView
Fragment3: onDestroyView
Fragment3: onDestroyView
Fragment3: onCreateAnimation enter:false
Fragment3aSub1: onCreateView
Fragment3aSub1: onViewCreated
Fragment3aSub1: onStart
Fragment3aSub1: onResume
Fragment3aSub1: onCreateAnimation enter:true
```
### In Fragment3Asub1 go back to Fragment3A
```
Fragment3aSub1: onStop
Fragment3aSub1: onDestroyView
Fragment3aSub1: onCreateAnimation enter:false
Fragment3aSub1: onDestroy
Fragment3: onCreateView
Fragment3: onViewCreated
Fragment3a: onCreateView
Fragment3b: onCreateView
Fragment3: onStart
Fragment3a: onStart
Fragment3b: onStart
Fragment3: onResume
Fragment3a: onResume
Fragment3b: onResume
Fragment3: onCreateAnimation enter:true
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:true
```
### From Fragment3A go to Fragment3B
```
Fragment3c: setUserVisibleHint isVisibleToUser:false - isResumed:false
Fragment3a: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment3b: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3c: onAttach
Fragment3c: onCreateView
Fragment3c: onStart
Fragment3c: onResume
```
### From Fragment3B go to Fragment3A
```
Fragment3b: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3c: onStop
Fragment3c: onDestroyView
Fragment3c: onDestroy
```
### From Fragment3 go to Fragment4
```
ContainerFragment3: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment3: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment3a: setUserVisibleHint isVisibleToUser:false - isResumed:true
ContainerFragment4: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment4: setUserVisibleHint isVisibleToUser:true - isResumed:true
```
### From Fragment4 go to Fragment3
```
ContainerFragment4: setUserVisibleHint isVisibleToUser:false - isResumed:true
Fragment4: setUserVisibleHint isVisibleToUser:false - isResumed:true
ContainerFragment3: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3: setUserVisibleHint isVisibleToUser:true - isResumed:true
Fragment3a: setUserVisibleHint isVisibleToUser:true - isResumed:true
```