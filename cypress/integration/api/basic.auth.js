describe('Basich Auth', function () {
    it('successfully logs in via GUI', function ()  {
        cy.intercept('GET', `${Cypress.env('apiUrl')}/models?userId=*`)
          .as('getUserModels')
        cy.loginViaAPI()
        // cy.wait('@getUserModels')
        // cy.contains('h2', 'Models').should('be.visible')
      })
});

// 
 