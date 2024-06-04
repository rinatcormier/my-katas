const obj1 = {
    name: 'Bob',
    age: 20
};

const obj2 = {
    height: 200,
    weight: 90
};

const obj3 = {
    name: 'Alice'
}

const clonedObj1 = {...obj1};
const mergedObjects = {...obj1, ...obj2};
const mergedWithConflictProp1 = {...obj1, ...obj3};  // wins the last prop with the same name
const mergedWithConflictProp2 = {...obj3, ...obj1};

console.log(clonedObj1);
console.log(mergedObjects);
console.log(mergedWithConflictProp1);
console.log(mergedWithConflictProp2);
