
// This function will calculate the total (estimated) appreciation of an investment at X rate over Y years
// If recurring, the original investment amount will be added to the result for each year

function GrowthEstimator() {
  
  // instance variables
  
  this.rate = 0;
  this.years = 0;
  this.recurring = false;
  this.logging = false;
  
  // setters
  
  this.setRate = (r) => rate = r;
  this.setYears = (y) => years = y;
  this.setRecurring = (r) => recurring = r;
  this.setLogging = (l) => logging = l;
  
  // business logic
  
  this.calculate = (investment) => {
    
	// helper functions
    
    const algorithm = (principal) => {
      return principal * (1 + rate);
    };
    const performAlgorithm = (iteration, outputVariable) => {
      if (iteration === 0) {
		  // first iteration; start with a blank slate
		  return algorithm(investment);
	  }
      if (recurring === true) {
		  return algorithm(outputVariable + investment);
	  }
	  return algorithm(outputVariable);
    };
	
    // logic
    
    let result = 0;
    
    for (let year = 0; year < years; year++) {
      result = performAlgorithm(year, result);
      if (logging) console.log('amount after year ' + (year+1) + ' ' + result);
    }
    
    return result;
   }
    
};